const { defineConfig } = require("cypress");
const { addMochawesomeReporter } = require("cypress-mochawesome-reporter/plugin");

module.exports = defineConfig({

  e2e: {
    baseUrl:'https://jsonplaceholder.typicode.com/',
    env:
    {
      apiURL:'https://jsonplaceholder.typicode.com'
    },
    viewportWidth:1920,
    viewportHeight:1080,
    pageLoadTimeout: 120000,
    setupNodeEvents(on, config) {
      // implement node event listeners here
      require('cypress-mochawesome-reporter/plugin')(on);
      return config;
    },
    reporter: 'cypress-mochawesome-reporter',
    reporterOptions: {
      reportDir: 'cypress/reports/report',
      overwrite: false,
      html: true,
      json: true,
      timestamp: 'mmddyyyy_HHMMss'
    }
  },
});
