package com.csipl.hrms.common.exception;

import com.csipl.hrms.common.exception.messages.error.ErrorCodes;

public class PersistenceException extends BaseException {

    public PersistenceException() {
        super(ErrorCodes.CUSTOM_EXCEPTION_2);
    }
}
