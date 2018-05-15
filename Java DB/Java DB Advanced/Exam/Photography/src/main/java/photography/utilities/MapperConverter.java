package photography.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 27/07/2017.
 */

@Component
public class MapperConverter {

    private ModelMapper modelMapper;

    public MapperConverter() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convert(S source, Class<D> destinationClass) {
        return this.modelMapper.map(source, destinationClass);
    }
}