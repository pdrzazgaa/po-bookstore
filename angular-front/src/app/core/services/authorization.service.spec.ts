/* eslint-disable no-undef */
import { AuthorizationService } from './authorization.service';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

let httpClientSpy: jasmine.SpyObj<HttpClient>;
let authService: AuthorizationService;

beforeEach(() => {
  httpClientSpy = jasmine.createSpyObj('HttpClient', ['post']);
  authService = new AuthorizationService(httpClientSpy);
  localStorage.removeItem('userId');
});

describe('AuthorizationService', () => {
  it('isLoggedIn should return false when user is not logged in', () => {
    expect(authService.isLoggedIn()).toBe(false);
  });

  it('should verify the user', (done: DoneFn) => {
    httpClientSpy.post.and.returnValue(of(1));
    authService.verify('m.a.markowiak@gmail.com', 'mariamakota').subscribe((res) => {
      expect(res).toBe(1);
      expect(httpClientSpy.post.calls.count()).toBe(1);
      done();
    });
  });

  it('should logout the user', () => {
    authService.logout();
    expect(authService.isLoggedIn()).toBe(false);
  });
});
