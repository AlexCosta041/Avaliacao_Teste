///<reference types="cypress"/>
describe('Guide',()=> {
    
    context('Acesso',()=>{
        it('deve clicar no link guide',()=>{
            cy.Guide()
            cy.screenshot()
           
        })

        it.only('Clicar e abrir o link album photos e salva array JSON',()=>{
            cy.Guide()
            cy.request(Cypress.env('apiURL')+'/albums/1/photos').then((response) => {
              const photos = response.body;
              
              // Salva os dados em um arquivo JSON na pasta fixtures
              cy.writeFile('cypress/fixtures/photos.json', photos); 
  
              // Validar os dados do objeto com id = 6
              const photoWithId6 = photos.find(photo => photo.id === 6);
              expect(photoWithId6).to.exist;
              expect(photoWithId6).to.have.property('title', 'accusamus ea aliquid et amet sequi nemo');
              expect(photoWithId6).to.have.property('url', 'https://via.placeholder.com/600/56a8c2');
              expect(photoWithId6).to.have.property('thumbnailUrl', 'https://via.placeholder.com/150/56a8c2');
          });


           // cy.get('.container > ul > :nth-child(3) > a').scrollIntoView()
           // cy.get('.container > ul > :nth-child(3) > a').click()

        })
  
    })
})
