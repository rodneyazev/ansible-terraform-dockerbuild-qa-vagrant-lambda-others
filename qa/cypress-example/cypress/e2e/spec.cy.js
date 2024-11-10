describe('template spec', () => {
  /*
  it('passes', () => {
    cy.visit('https://example.cypress.io')
  })*/

  it('Login success', () => {
    cy.visit('https://the-internet.herokuapp.com/login')
    cy.get('#username').type('tomsmith')
    cy.get('#password').type('SuperSecretPassword!')
    cy.get('[type="submit"]').click()
    cy.get('h2').should('contain','Secure Area')
  })

  it('Validando checkboxes marcado', () => {
    cy.visit('https://the-internet.herokuapp.com/checkboxes')
    cy.get('#checkboxes > :nth-child(3)').should('be.checked')
  })

  it('Validando checkboxes desmarcado', () => {
    cy.visit('https://the-internet.herokuapp.com/checkboxes')
    cy.get('#checkboxes > :nth-child(1)').should('not.be.checked')
  })

  it('Validando elemento hiden', () => {
    cy.visit('https://the-internet.herokuapp.com/dynamic_loading/1')
    cy.get('button').click()
    cy.get('#finish > h4').should('be.visible')
  })

  it('Utilizando base url', () => {
    cy.visit('/key_presses')
  })

  it('Login success - Debug', () => {
    cy.visit('https://the-internet.herokuapp.com/login')
    cy.get('#username').type('tomsmith').debug()
    cy.get('#password').type('SuperSecretPassword!').debug()
    cy.get('[type="submit"]').click().debug()
    cy.get('h2').should('contain','Secure Area').debug()
  })

  it('Utilizando fixture', () => {
    cy.fixture('example').then((dataTest) =>{
      cy.visit('https://the-internet.herokuapp.com/login')
      cy.get('#username').type(dataTest.username)
      cy.get('#password').type(dataTest.password)
      cy.get('[type="submit"]').click()
    })
  })
})