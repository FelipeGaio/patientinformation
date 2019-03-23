package com.obs.patient.exception;

public class NotFoundException extends Exception
{
    private static final long serialVersionUID = 8536798262641937174L;

    public NotFoundException(String message)
    {
        super(message);
    }

}
