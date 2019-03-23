package com.obs.patient.exception;

/**
 * Bad request exception 400 
 * @author Felipe
 *
 */
public class BadRequestException extends Exception
{
    private static final long serialVersionUID = 1574119354950745139L;

    public BadRequestException(String message)
    {
        super(message);
    }
}
