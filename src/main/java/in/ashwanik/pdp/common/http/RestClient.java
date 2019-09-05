package in.ashwanik.pdp.common.http;

import in.ashwanik.pdp.common.utils.Json;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OKHttp based REST HttpClient
 */
@Builder
@Slf4j
public class RestClient {
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient httpClient;

    public <S, E, K> RestResponse<S, E> post(Class<S> successClazz, Class<E> errorClazz, K data, RequestParam requestParams) {
        RequestBody body = RequestBody.create(JSON, data == null ? "" : Json.serialize(data));
        Request.Builder builder = new Request.Builder()
                .url(requestParams.getUrl())
                .post(body);
        addHeaders(requestParams.getHeaders(), builder);
        return handleResponse(successClazz, errorClazz, builder.build(), requestParams);
    }

    public <S, E> RestResponse<S, E> get(Class<S> successClazz, Class<E> errorClazz, RequestParam requestParams) {
        Request.Builder builder = new Request.Builder()
                .url(requestParams.getUrl());
        addHeaders(requestParams.getHeaders(), builder);
        return handleResponse(successClazz, errorClazz, builder.build(), requestParams);
    }

    private void addHeaders(Map<String, String> headers, Request.Builder builder) {
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    private <S, E> RestResponse<S, E> handleResponse(Class<S> successClazz, Class<E> errorClazz, Request request, RequestParam requestParams) {
        try (Response response = getResponse(request, requestParams.getTimeout())) {
            if (response.isSuccessful()) {
                return RestResponse
                        .<S, E>builder()
                        .success(Json.deserialize(response.body().string(), successClazz))
                        .build();
            } else {
                return RestResponse
                        .<S, E>builder()
                        .error(Json.deserialize(response.body().string(), errorClazz))
                        .build();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private Response getResponse(Request request, int timeout) throws IOException {
        OkHttpClient client = httpClient.newBuilder()
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();
        return client.newCall(request).execute();
    }
}

