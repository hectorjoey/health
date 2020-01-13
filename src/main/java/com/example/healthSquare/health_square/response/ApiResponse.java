package com.example.healthSquare.health_square.response;

/*created by Hector Developers
06-08-2019
*/

public class ApiResponse {

    private int status;
    private String message;
    private Object result;

    public ApiResponse(int status, String message, Object result){
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }
    public String getMessage(){
        return message;
    }

}