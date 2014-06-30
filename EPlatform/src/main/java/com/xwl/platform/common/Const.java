/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.common;

/**
 * 
 * @author 212361448
 */
@SuppressWarnings(
{
        "javadoc", "nls"
})
public abstract class Const
{
    public static final String RE_CODE                   = "reCode";
    public static final int    RE_CODE_SUCCESS           = 0;
    public static final int    RE_CODE_ERROR             = -1;

    public static final int    RE_WRONG_PARAMETER        = 3;
    public static final int    RE_REGISTER_FAILED_REPEAT = 1;
    public static final int    RE_SMSCODE_VERIFY_FAILED  = 2;

    public static final int    RE_CUSTOMER_NOT_EXIT      = 4;
    public static final int    RE_PASSWORD_WRONG         = 5;

    // 顺序重要不能调换
    public static final int    GENDER_UNCHOICE           = 0;
    public static final int    GENDER_MALE               = 1;
    public static final int    GENDER_FEMALE             = 2;

    public static final int    PAGE_SIZE                 = 20;

    public static final String NO_CHOOSE                 = "-1";

    // system logs
    public static final int    LOGTYPE_INFO              = 1;
    public static final int    LOGTYPE_WARNING           = 2;
    public static final int    LOGTYPE_ERROR             = 3;
    public static final int    LOGTYPE_FATAL             = 4;

}
