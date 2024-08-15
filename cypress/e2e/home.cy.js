///<reference types="cypress"/>

describe('home', () => {
  it.only('Acessar página jsonplaceholder', () => {
    cy.VisitHome()

   // cy.title().should('eq', '{JSON} PlaceholderJSONPlaceholder - Free Fake REST API')
  })
})

