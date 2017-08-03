package products.dto.views;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class SummaryUsersSoldProductsViewDto {

    @Expose
    private int usersCount;

    @Expose
    private Set<UserSoldProductsViewDto> users;

    public SummaryUsersSoldProductsViewDto() {
    }

    public int getUsersCount() {
        return this.usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserSoldProductsViewDto> getUsers() {
        return this.users;
    }

    public void setUsers(Set<UserSoldProductsViewDto> users) {
        this.users = users;
        this.setUsersCount(users.size());
    }
}
