// @ts-check
const { test, expect } = require('@playwright/test');

test('Nome do cenário', async ({ page }) => {
  await page.goto('https://the-internet.herokuapp.com/login');
  await page.getByRole('textbox',{name:'username'}).fill('tomsmith');
  await page.getByLabel('password').fill('SuperSecretPassword!');
  await page.locator('[type="submit"]').click();

  await expect(page.locator('h2')).toHaveText('Secure Area');
});


test('Validando elemento hidden', async ({ page }) => {
  await page.goto('https://the-internet.herokuapp.com/dynamic_loading/1');
  await page.getByRole('button',{name:'Start'}).click();
  const locator = await page.getByText('Hello World');
  await expect(locator).toBeVisible({ timeout: 15000 });
});