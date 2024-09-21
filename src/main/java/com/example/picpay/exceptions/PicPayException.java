package com.example.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException  extends  RuntimeException{

    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Picpay internal server error");
        return  pb;
    }
}
