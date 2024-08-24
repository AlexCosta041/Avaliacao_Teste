describe('API Tests - JSONPlaceholder', () => {
    // 1. Requisição GET para buscar um comentário específico
    it('Solicitação GET - Validar comentário por nome', () => {
        cy.request({
            method: 'GET',
            url: Cypress.env('apiURL')+'/comments',
            qs: { name: 'alias odio sit' } // Filtro pelo nome
        }).then((response) => {
            expect(response.status).to.eq(200); // Valida status code

            const comment = response.body.find(comment => comment.name === 'alias odio sit');
            expect(comment).to.exist; // Verifica se o comentário foi encontrado
            expect(comment.email).to.eq('Lew@alysha.tv'); // Valida o email do comentário
        });
    });

    // 2. Requisição POST para criar um novo usuário
    it('Solicitação POST - Criar um novo usuário', () => {
        const user={
            name: 'John Doe',
            username: 'johndoe',
            email: 'johndoe@example.com',
            address: {
                street: 'Kulas Light',
                suite: 'Apt. 556',
                city: 'Gwenborough',
                zipcode: '92998-3874',
                geo: {
                    lat: '-37.3159',
                    lng: '81.1496'
                }
            },
            phone: '1-770-736-8031',
            website: 'hildegard.org',
            company: {
                name: 'Romaguera-Crona',
                catchPhrase: 'Multi-layered client-server neural-net',
                bs: 'harness real-time e-markets'
            }  
        }
        cy.request({
            method: 'POST',
            url: Cypress.env('apiURL')+'/users',
            body:user
        }).then((response) => {
            expect(response.status).to.eq(201); // Valida status code
            expect(response.body).to.have.property('id'); // Valida que o ID foi retornado
        });
    });

    // 3. Requisição PUT para atualizar um usuário existente
    it('Solicitação PUT - Atualizar dados do usuário', () => {
        cy.request({
            method: 'PUT',
            url: Cypress.env('apiURL')+'/users/5',
            body: {
                email: 'newemail@example.com',
                address: {
                    geo: {
                        lat: '-50.3159', // Nova latitude
                        lng: '100.1496'  // Nova longitude
                    }
                }
            }
        }).then((response) => {
            expect(response.status).to.eq(200); // Valida status code

            // Valida que os dados foram atualizados
            expect(response.body.email).to.eq('newemail@example.com');
            expect(response.body.address.geo.lat).to.eq('-50.3159');
            expect(response.body.address.geo.lng).to.eq('100.1496');
        });
    });
});
