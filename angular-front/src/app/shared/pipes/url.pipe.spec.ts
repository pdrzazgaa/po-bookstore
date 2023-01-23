/* eslint-disable no-undef */
import { UrlPipe } from './url.pipe';

describe('UrlPipe', () => {
  const pipe = new UrlPipe();

  it('transforms "literatura" to "lieratura"', () => {
    expect(pipe.transform('literatura')).toBe('literatura');
  });

  it('transforms "literatura angielska" to "lieratura-angielska"', () => {
    expect(pipe.transform('literatura angielska')).toBe('literatura-angielska');
  });

  it('transforms "Wycieczki i Podróze" to loweracase "wycieczki-i-podróze"', () => {
    expect(pipe.transform('Wycieczki i Podróze')).toBe('wycieczki-i-podróze');
  });
});
