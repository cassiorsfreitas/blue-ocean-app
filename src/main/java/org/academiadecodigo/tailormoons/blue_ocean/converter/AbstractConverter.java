package org.academiadecodigo.tailormoons.blue_ocean.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A generic converter to be used as a base for concrete converter implementations
 * @param <S> the source type
 * @param <T> the target type
 */
public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    /**
     * Converts the source list of type S to target type T
     *
     * @param listToConvert the list to convert
     * @return the list of converted elements
     */
    public List<T> convert(List<S> listToConvert) {

        List<T> conversions = new ArrayList<>(listToConvert.size());

        for (S toConvert : listToConvert) {
            conversions.add(convert(toConvert));
        }

        return conversions;
    }

    // Added method overload to be able to convert Customer and Flag Sets
    public Set<T> convert(Set<S> listToConvert) {

        Set<T> conversions = new HashSet<>(listToConvert.size());

        for (S toConvert : listToConvert) {
            conversions.add(convert(toConvert));
        }

        return conversions;
    }

}
