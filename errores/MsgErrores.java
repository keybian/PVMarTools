
package com.kp.martuls.errores;

/**
 * ExceptionMetier.java Type de Exception qui se compose d'un message d'erreur.
 * 
 *
 */
public class MsgErrores extends Exception
{

    /** Constant : serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    private final String description;

    public MsgErrores(String message, String description)
    {
        super(message);
        this.description = description;
    }

    /**
     * Constructor qui a comme paramètre d'entrée un message d'erreur.
     * 
     * @param msg : message d'erreur qui va lancer l'éxception.
     */
    public MsgErrores(String msg)
    {
        this(msg, null);
    }

    /**
     * Constructor par défaut.
     */
    public MsgErrores()
    {
        this(null, null);
    }

    public String getDescription()
    {
        return description;
    }
}
