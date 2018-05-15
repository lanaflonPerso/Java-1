package student.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import student.system.entities.Town;
import student.system.entities.User;
import student.system.services.TownService;
import student.system.services.UserService;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Controller
public class UserController {
    private static final String FIRST_IMAGE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\img\\peach.png";
    private static final String SECOND_IMAGE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\img\\desk.png";
    private static final String THIRD_IMAGE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataIntro\\src\\main\\resources\\img\\door.png";

    private final UserService userService;
    private final TownService townService;

    @Autowired
    public UserController(UserService userService, TownService townService) {
        this.userService = userService;
        this.townService = townService;
    }

    public void removeInactiveUsers(String inputDateString) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(inputDateString, dtf);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());

        byte[] bytesFromFirstFilePath = this.createBytesFromFilePath(FIRST_IMAGE_PATH);
        byte[] bytesFromSecondFilePath = this.createBytesFromFilePath(SECOND_IMAGE_PATH);
        byte[] bytesFromThirdFilePath = this.createBytesFromFilePath(THIRD_IMAGE_PATH);

        this.createUser("nasko", "1As(dsxf", "nasko@gmail.bg", "Atanas", "Panaiotov", 33, LocalDateTime.of(LocalDate.parse("10 Sep 2015", dtf), LocalDateTime.now().toLocalTime()), bytesFromFirstFilePath);

        this.createUser("misho", "7f_Ddfgf", "misho@abv.bg", "Mihail", "Dimitrov", 28, LocalDateTime.of(LocalDate.parse("18 Jun 2017", dtf), LocalDateTime.now().toLocalTime()), bytesFromSecondFilePath);

        this.createUser("kremy", "Ky6<aaaa", "kremy@yahoo.com", "Kremena", "Petrova", 21, LocalDateTime.of(LocalDate.parse("27 Jan 2010", dtf), LocalDateTime.now().toLocalTime()), bytesFromThirdFilePath);

        List<User> allUsers = this.userService.findAll();

        allUsers.stream()
                .filter(x -> x.getLastTimeLoggedIn().isBefore(dateTime))
                .forEach(x -> x.setDeleted(true));

        this.userService.updateMany(allUsers);

        List<User> deletedUsers = this.userService.findDeletedUsers();

        System.out.println(String.format("%s users have been deleted", deletedUsers.size() == 0 ? "No" : String.valueOf(deletedUsers.size())));
    }

    public void usersWithPicturesWidthBiggerThan(int width) throws IOException {
        List<byte[]> collect = this.userService.findAll().stream()
                .map(User::getProfilePicture)
                .collect(Collectors.toList());

        int countOfUsers = 0;
        for (byte[] bytes : collect) {
            BufferedImage imageFromBytes = this.createImageFromBytes(bytes);
            if (imageFromBytes.getWidth() > width) {
                countOfUsers++;
            }
        }
        System.out.println(String.format("%s users have profile pictures wider than %d pixels", countOfUsers == 0 ? "No" : String.valueOf(countOfUsers), width));
    }

    public void usersByEmailProvider(String provider) {
        List<User> allUsers = this.userService.findAll();

        allUsers.stream()
                .filter(x -> x.getEmail().endsWith(provider))
                .forEach(x -> System.out.println(String.format("%s %s", x.getUsername(), x.getEmail())));
    }

    private void createUser(String username, String password, String email, String firstName, String lastName, int age, LocalDateTime dateTime, byte[] profilePicture) {
        Town town = new Town();
        town.setCountry("Bulgaria");
        town.setName("Sofia");
        this.townService.createOne(town);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setRegisteredOn(LocalDateTime.now());
        user.setLastTimeLoggedIn(dateTime);
        user.setBornTown(town);
        user.setCurrentlyLivingTown(town);
        user.setProfilePicture(profilePicture);

        this.userService.createOne(user);
    }

    private byte[] createBytesFromFilePath(String firstImagePath) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(firstImagePath);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bos.toByteArray();
    }

    private BufferedImage createImageFromBytes(byte[] imageData) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        Iterator<?> readers = ImageIO.getImageReadersByFormatName("png");

        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();

        Image image = reader.read(0, param);

        return new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

    }
}