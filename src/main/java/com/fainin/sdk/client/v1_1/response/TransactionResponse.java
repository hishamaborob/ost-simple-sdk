package com.fainin.sdk.client.v1_1.response;

import com.fainin.sdk.client.OSTApiResponse;
import com.fainin.sdk.client.v1_1.response.data.TransactionData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by hishamaborob on 23-Mar-18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse extends ApiResponse implements OSTApiResponse {

    private TransactionData data;

    public TransactionData getData() {
        return data;
    }

    public void setData(TransactionData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "success=" + getSuccess() +
                ", err=" + getErr() +
                ", data=" + data +
                '}';
    }
}
