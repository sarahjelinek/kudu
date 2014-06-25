// Copyright (c) 2013, Cloudera, inc.
package kudu.rpc;

import kudu.WireProtocol;

/**
 * This class is used for errors sent in response to a RPC.
 */
@SuppressWarnings("serial")
public class KuduServerException extends KuduException {

  KuduServerException(RpcHeader.ErrorStatusPB errorStatus) {
    this(errorStatus.getMessage(), errorStatus.getCode().toString(),
        errorStatus.getCode().getNumber(), null);
  }

  KuduServerException(WireProtocol.AppStatusPB appStatus) {
    this(appStatus.getMessage(), appStatus.getCode().toString(),
        appStatus.getCode().getNumber(), null);
  }

  KuduServerException(String message, String errorDesc, int errCode, Throwable cause) {
    super(errorDesc + "[code " + errCode + "]: "  + message, cause);
  }
}