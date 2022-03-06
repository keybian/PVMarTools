
package com.kp.martuls.configuracion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Level;

import com.kp.martuls.configuracion.KeyGestionlogger;

/**
 *  Class KeyGestionlogger
 */
public class KeyGestionlogger
{

    /**
     * logger.
     */
    private Log logger;

    /**
     * field separator.
     */
    private String fieldSeparator;

    /**
     * level.
     */
    private Level level;

    /**
     * Constant : DEFAULT_FIELD_SEPARATOR.
     */
    public static final String DEFAULT_FIELD_SEPARATOR = "|";

    /**
     * Constant : BUSINESS_LOG.
     */
    public static final KeyGestionlogger BUSINESS_LOG = new KeyGestionlogger("business")
    {
    };

    /**
     * Constant : API_IO_LOG.
     */
    public static final KeyGestionlogger API_IO_LOG = new KeyGestionlogger("api-io", Level.DEBUG)
    {
    };

    /**
     * Constant : API_AUDIT_LOG.
     */
    public static final KeyGestionlogger API_AUDIT_LOG = new KeyGestionlogger("api-audit")
    {
    };

    /**
     * Constant : EXCEPTIONS_LOG.
     */
    public static final KeyGestionlogger EXCEPTIONS_LOG = new KeyGestionlogger("excepciones", Level.ERROR)
    {
    };

    /**
     * 
     * 
     * @param name : name
     */
    public KeyGestionlogger(String name)
    {
        logger = LogFactory.getLog(name);
        this.fieldSeparator = DEFAULT_FIELD_SEPARATOR;
        this.level = Level.INFO;
    }

    /**
     * 
     * 
     * @param name  : name
     * @param level : level  log
     */
    public KeyGestionlogger(String name, Level level)
    {
        this(name);
        this.level = level;
    }

    /**
     * 
     * 
     * @param name           : name
     * @param level          : level  log
     * @param fieldSeparator : fiel separator 
     */
    public KeyGestionlogger(String name, Level level, String fieldSeparator)
    {
        this(name);
        this.level = level;
        this.fieldSeparator = fieldSeparator;
    }

    /**
     * methode Log 
     * 
     * @param message : message
     */
    public void log(String message)
    {
        /*
         * debug
         */
        if (logger.isDebugEnabled() && level.equals(Level.DEBUG))
        {
            logger.debug(message);
        }
        /*
         * error
         */
        if (logger.isErrorEnabled() && level.equals(Level.ERROR))
        {
            logger.error(message);
        }
        /*
         * info
         */
        if (logger.isInfoEnabled() && level.equals(Level.INFO))
        {
            logger.info(message);
        }
        /*
         * trace
         */
        if (logger.isTraceEnabled() && level.equals(Level.TRACE))
        {
            logger.trace(message);
        }
        /*
         * warn
         */
        if (logger.isWarnEnabled() && level.equals(Level.WARN))
        {
            logger.warn(message);
        }
    }

    /**
     * methode Log : 
     * 
     * @param messages : messages
     */
    public void log(String... messages)
    {

        StringBuilder sbuilder = new StringBuilder();
        for (String msg : messages)
        {
            /*
             * appel builder
             */
            sbuilder.append(msg).append(fieldSeparator);
        }

        log(sbuilder.toString());
    }

    /**
     * methode Builds the message exception 
     * 
     * @param message   : message
     * @param exception : exception technique
     * @return string
     */
    private String buildMessageException(String message, Throwable exception)
    {
        Throwable cause = exception;
        StringBuilder msgException = new StringBuilder();

        while (cause.getCause() != null)
        {
            cause = cause.getCause();
        }

        if (cause.getMessage() == null)
        {
            msgException.append("").append(fieldSeparator);

            if (message == null)
            {
                msgException.append("").append(fieldSeparator);
            }
            else
            {
                msgException.append(message).append(fieldSeparator);
            }
        }
        else
        {
            msgException.append(cause.getMessage());

            if (message == null)
            {
                msgException.append("").append(fieldSeparator);
            }
            else
            {
                msgException.append(message).append(fieldSeparator);
            }
        }

        
        return msgException.toString();

    }

    /**
     * methode Log : 
     * 
     * @param message   : message
     * @param exception : exception
     */
    public void log(String message, Throwable exception)
    {
        /*
         * debug
         */
        if (logger.isDebugEnabled() && level.equals(Level.DEBUG))
        {
            logger.debug(buildMessageException(message, exception), exception);
        }
        /*
         * error
         */
        if (logger.isErrorEnabled() && level.equals(Level.ERROR))
        {
            logger.error(buildMessageException(message, exception), exception);
        }
        /*
         * info
         */
        if (logger.isInfoEnabled() && level.equals(Level.INFO))
        {
            logger.info(buildMessageException(message, exception), exception);
        }
        /*
         * trace
         */
        if (logger.isTraceEnabled() && level.equals(Level.TRACE))
        {
            logger.trace(buildMessageException(message, exception), exception);
        }
        /*
         * warn
         */
        if (logger.isWarnEnabled() && level.equals(Level.WARN))
        {
            logger.warn(buildMessageException(message, exception), exception);
        }
    }

    
    public void log(Throwable exception)
    {
        log(buildMessageException(null, exception), exception);
    }

    
    public boolean isDebugEnabled()
    {
        return logger.isDebugEnabled();
    }

    
    public Level getLevel()
    {
        return level;
    }

    
    public void setLevel(Level level)
    {
        this.level = level;
    }
}
