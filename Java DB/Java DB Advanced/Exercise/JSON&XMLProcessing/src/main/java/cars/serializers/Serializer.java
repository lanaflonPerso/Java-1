package cars.serializers;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public interface Serializer {

    <T> T deserialize(Class<T> tClass, String fileName);

    <T> void serialize(T object, String fileName);
}
