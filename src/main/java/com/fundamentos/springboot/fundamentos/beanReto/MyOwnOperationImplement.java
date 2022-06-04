package com.fundamentos.springboot.fundamentos.beanReto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyOwnOperationImplement implements MyOwnOperation {
    @Override
    public List<Integer> generateRandomElements(int maxElement, int maxLimit) {
        return new Random().ints(0, maxElement)
                .limit(maxLimit)
                .boxed()    // Regresa un IntStream
                .collect(Collectors.toList());
    }
}
