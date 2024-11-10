const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    defaultCommandTimeout: 15000,
    pageLoadTimeout: 15000,
    retries: {"runMode": 1,"openMode":1}, // runMode:  command line run mode - CLI || openMode: default run mode - GUI
    baseUrl: 'https://the-internet.herokuapp.com',
    video: true
  },
});
