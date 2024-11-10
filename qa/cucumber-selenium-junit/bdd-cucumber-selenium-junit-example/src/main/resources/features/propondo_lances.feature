# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um lance valido
	Dado um lance valido
	Quando propoe lance ao leilao
	Então o lance eh aceito
	
	
Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "Fulano"
	E um lance de 15.0 reais do usuario "Beltrano"
	Quando propoe varios lances ao leilao
	Então os lances sao aceitos

