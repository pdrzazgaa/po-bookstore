/* eslint-disable no-undef */

import { FromUrlPipe } from './from-url.pipe';

describe('UrlPipe', () => {
  const pipe = new FromUrlPipe();

  it('transforms "literatura" to "lieratura"', () => {
    expect(pipe.transform('literatura')).toBe('literatura');
  });

  it('transforms "literatura-angielska" to "lieratura angielska"', () => {
    expect(pipe.transform('literatura-angielska')).toBe('literatura angielska');
  });
});
