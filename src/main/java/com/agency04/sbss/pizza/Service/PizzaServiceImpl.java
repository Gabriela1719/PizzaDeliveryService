package com.agency04.sbss.pizza.Service;

import com.agency04.sbss.pizza.Model.Pizza;
import com.agency04.sbss.pizza.Model.PizzaOrder;
import com.agency04.sbss.pizza.Repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PizzaService")
public class PizzaServiceImpl implements PizzaService
{
    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository thePizzaRepository) {
        pizzaRepository = thePizzaRepository;
    }

    @PostConstruct
    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }
    @Override
    public Pizza findById(int theId) {
        Optional<Pizza> result = pizzaRepository.findById(theId);
        if (result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Did not find Pizza id - " + theId);
        }
    }

    @Override
    public void save(Pizza thePizza) {
        pizzaRepository.save(thePizza);
    }

    @Override
    public void deleteById(int theId) {
        pizzaRepository.deleteById(theId);
    }

}
