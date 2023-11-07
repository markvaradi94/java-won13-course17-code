package ro.fasttrackit.course17.homework.ex2;

import lombok.Builder;

@Builder
public record Electronics(
        String name,
        int price,
        Category category
) implements ShopItem {
}
