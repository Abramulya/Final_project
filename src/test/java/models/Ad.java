package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    private String title;
    private String description;
    private int price;
    private String category;
    private String phone;
}