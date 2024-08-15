// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })
Cypress.Commands.add('createTask',(taskname='')=>{
    cy.visit('/')
    if(taskname!==''){
     //cy.get('#newTask').type(faker.music.songName())
     cy.get('#newTask').type(taskname)
    }
 
  cy.contains('button','Create').click()
 })
 
 Cypress.Commands.add('VisitHome',()=>{
   cy.visit('/')
 })

 Cypress.Commands.add('Guide',()=>{
   cy.visit('/')
   cy.get('nav a').contains('Guide').click()
 })
 
 Cypress.Commands.add('removeaskbyname', (taskname)=>{
    cy.request({
 
       url:'http://localhost:3333/helper/tasks',
       method:'DELETE',
       body:{name:taskname}
    }).then(response=>{
       expect(response.status).to.eq(204)
    })
 })