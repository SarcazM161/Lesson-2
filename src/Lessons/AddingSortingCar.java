package Lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddingSortingCar
{
    public void AddingSortingCar() {
        ArrayList<Car> park = new ArrayList<Car>() {{
            add(new Car("cедан", "Лада"));
            add(new Car("хэтчбек", "Лада-Веста"));
            add(new Car("cедан", "Мерседес"));
            add(new Car("кроссовер", "Бмв"));
            add(new Car("кроссовер", "Пежо  "));
            add(new Car("cедан", "Тойота"));
            add(new Car("хэтчбек", "Форд"));
            add(new Car("хэтчбек", "Лада-2109"));
            add(new Car("cедан", "Бмв-X5"));
        }};


        System.out.println(filtered(park, "кроссовер"));
        System.out.println(filtered(park, "хэтчбек"));
        System.out.println(filtered(park, "cедан"));
    }

    private List filtered(ArrayList<Car> park, String type) {
        List<Car> filtered =
                park
                        .stream()
                        .filter(p -> p.type.startsWith(type))
                        .collect(Collectors.toList());
        return filtered;
    }
}



