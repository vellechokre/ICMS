package com.vellechokre.core;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.helpers.MessageFormatter;

import com.vellechokre.core.constants.LoggerType;
import com.vellechokre.core.util.LF;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public class CustomLogger {

    private CustomLogger() {

        throw new IllegalStateException("Utility class");
    }

    public static void doLog(final String message, final String tenantId,
                             final LoggerType loggerType, final Logger logger) {

        doLog(message, tenantId, loggerType, logger, null);
    }

    public static void doLog(final String message, final String tenantId,
                             final LoggerType loggerType, final Logger logger,
                             final Object[] params) {

        switch (loggerType) {
            case TRACE:
                logTrace(message, tenantId, logger, params);
                break;
            case INFO:
                logInfo(message, tenantId, logger, params);
                break;
            case DEBUG:
                logDebug(message, tenantId, logger, params);
                break;
            case ERROR:
                logError(message, tenantId, logger, params);
                break;
            default:
                logger.error("Invalid loggerType {} , message that need to be printed is {}",
                        loggerType, message);
                break;
        }
    }

    private static void logTrace(final String message, final String tenantId, final Logger logger,
                                 final Object[] argumentArray) {

        if (logger.isTraceEnabled()) {
            final String formattedMessage =
                    (Objects.isNull(argumentArray) ? message
                                                   : MessageFormatter
                                                           .arrayFormat(message, argumentArray)
                                                           .getMessage());
            logger.trace(LF.format(formattedMessage, tenantId));
        }
    }

    private static void logDebug(final String message, final String tenantId, final Logger logger,
                                 final Object[] argumentArray) {

        if (logger.isDebugEnabled()) {
            final String formattedMessage =
                    (Objects.isNull(argumentArray) ? message
                                                   : MessageFormatter
                                                           .arrayFormat(message, argumentArray)
                                                           .getMessage());
            logger.debug(LF.format(formattedMessage, tenantId));
        }
    }

    private static void logInfo(final String message, final String tenantId, final Logger logger,
                                final Object[] argumentArray) {

        if (logger.isInfoEnabled()) {
            final String formattedMessage =
                    (Objects.isNull(argumentArray) ? message
                                                   : MessageFormatter
                                                           .arrayFormat(message, argumentArray)
                                                           .getMessage());
            logger.info(LF.format(formattedMessage, tenantId));
        }
    }

    private static void logError(final String message, final String tenantId, final Logger logger,
                                 final Object[] argumentArray) {

        if (logger.isErrorEnabled()) {
            final String formattedMessage =
                    (Objects.isNull(argumentArray) ? message
                                                   : MessageFormatter
                                                           .arrayFormat(message, argumentArray)
                                                           .getMessage());
            logger.error(LF.format(formattedMessage, tenantId));
        }
    }
}
