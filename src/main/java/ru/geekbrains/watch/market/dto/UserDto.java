package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String username;

    public UserDto(String username) {
        this.username = username;
    }
}
