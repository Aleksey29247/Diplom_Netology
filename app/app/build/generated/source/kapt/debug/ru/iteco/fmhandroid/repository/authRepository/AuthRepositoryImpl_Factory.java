// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.repository.authRepository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.iteco.fmhandroid.api.AuthApi;
import ru.iteco.fmhandroid.api.RefreshTokensApi;
import ru.iteco.fmhandroid.auth.AppAuth;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<AuthApi> authApiProvider;

  private final Provider<RefreshTokensApi> refreshTokensApiProvider;

  private final Provider<AppAuth> appAuthProvider;

  public AuthRepositoryImpl_Factory(Provider<AuthApi> authApiProvider,
      Provider<RefreshTokensApi> refreshTokensApiProvider, Provider<AppAuth> appAuthProvider) {
    this.authApiProvider = authApiProvider;
    this.refreshTokensApiProvider = refreshTokensApiProvider;
    this.appAuthProvider = appAuthProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(authApiProvider.get(), refreshTokensApiProvider.get(), appAuthProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<AuthApi> authApiProvider,
      Provider<RefreshTokensApi> refreshTokensApiProvider, Provider<AppAuth> appAuthProvider) {
    return new AuthRepositoryImpl_Factory(authApiProvider, refreshTokensApiProvider, appAuthProvider);
  }

  public static AuthRepositoryImpl newInstance(AuthApi authApi, RefreshTokensApi refreshTokensApi,
      AppAuth appAuth) {
    return new AuthRepositoryImpl(authApi, refreshTokensApi, appAuth);
  }
}
