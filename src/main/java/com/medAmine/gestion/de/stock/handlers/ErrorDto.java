package com.medAmine.gestion.de.stock.handlers;

import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto  {
    private Integer httpCode;
    private String message;
    private List<String> error = new ArrayList<>();
    private ErrorCode errorCode;


}
