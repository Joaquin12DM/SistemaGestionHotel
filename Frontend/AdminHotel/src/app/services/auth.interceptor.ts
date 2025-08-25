import { Injectable, inject } from '@angular/core';
import { HttpRequest, HttpHandlerFn, HttpInterceptorFn } from '@angular/common/http';
import { TokenService } from './token.service';

// Interceptor funcional para Angular v17+
export const authInterceptor: HttpInterceptorFn = (request, next) => {
  const tokenService = inject(TokenService);
  const token = tokenService.getToken();
  
  if (token) {
   
    const authReq = request.clone({
      headers: request.headers.set('Authorization', `Bearer ${token}`)
    });
    return next(authReq);
  }
  
  return next(request);
};
