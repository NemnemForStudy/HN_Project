package com.example.team2.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    //? D 정의해주기 위해 ResponseDto 앞에 D붙여줌
    public static <D> ResponseDto<D> setSuccess(String message, D data){
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message){
        return ResponseDto.set(false, message, null);
    }
}
