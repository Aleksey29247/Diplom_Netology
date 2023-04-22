// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@ScopeMetadata
@QualifierMetadata("qualifier.NonAuthorized")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_NonAuthorizedOkhttpFactory implements Factory<OkHttpClient> {
  private final Provider<HttpLoggingInterceptor> interceptorProvider;

  public NetworkModule_NonAuthorizedOkhttpFactory(
      Provider<HttpLoggingInterceptor> interceptorProvider) {
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return nonAuthorizedOkhttp(interceptorProvider.get());
  }

  public static NetworkModule_NonAuthorizedOkhttpFactory create(
      Provider<HttpLoggingInterceptor> interceptorProvider) {
    return new NetworkModule_NonAuthorizedOkhttpFactory(interceptorProvider);
  }

  public static OkHttpClient nonAuthorizedOkhttp(HttpLoggingInterceptor interceptor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.nonAuthorizedOkhttp(interceptor));
  }
}
