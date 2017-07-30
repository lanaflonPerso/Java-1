package game.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 27/07/2017.
 */
@Component
public class MapperConverter {

    private ModelMapper modelMapper;

    public MapperConverter() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D convertOne(S source, Class<D> destinationClass) {
        return this.modelMapper.map(source, destinationClass);
    }

    public <S, D> void convertOne(S source, D destination) {
        this.modelMapper.map(source, destination);
    }

    @SuppressWarnings("unchecked")
    public <S, D> Set<D> convertList(Set<S> sources, Class<D> destinationClass) throws IllegalAccessException, InstantiationException {
        Set<D> destinations = (Set<D>) new HashSet<>();

        for (S source : sources) {
            destinations.add(this.convertOne(source, destinationClass));
        }

        return destinations;
    }
}