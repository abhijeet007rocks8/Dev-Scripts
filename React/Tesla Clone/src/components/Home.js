import React from 'react'
import styled from 'styled-components'
import Section from './Section'

function Home() {
	return (
		<Container>
			<Section 
				title="Model S" 
				description="Order Online fro Touchless Delivery"
				backgroundImg="model-s.jpg"
				leftBtnText="Custom order"
				rightBtnText="Exisiting inventory"
			/>
			<Section 
				title="Model 3" 
				description="Order Online fro Touchless Delivery"
				backgroundImg="model-3.jpg"
				leftBtnText="Custom order"
				rightBtnText="Exisiting inventory"
			/>
			<Section 
				title="Model X" 
				description="Order Online fro Touchless Delivery"
				backgroundImg="model-x.jpg"
				leftBtnText="Custom order"
				rightBtnText="Exisiting inventory"
			/>
			<Section 
				title="Model Y" 
				description="Order Online fro Touchless Delivery"
				backgroundImg="model-y.jpg"
				leftBtnText="Custom order"
				rightBtnText="Exisiting inventory"
			/>
			<Section
				title="Lowerst Cost Solar Panels in America"
				description="Money-back guarantee"
				backgroundImg="solar-panel.jpg"
				leftBtnText="Oder now"
				rightBtnText="Learn more"
			>
			</Section>
			<Section
				title="Solar for New Roofs"
				description="Solar Roof Costs Less Than a New"
				backgroundImg="solar-roof.jpg"
				leftBtnText="Oder now"
				rightBtnText="Learn more"
			>
			</Section>
			<Section
				title="Accessories"
				description=""
				backgroundImg="accessories.jpg"
				leftBtnText="Shop now"
			>
			</Section>
		</Container>
	)
}

export default Home

const Container = styled.div `
	height: 100vh;	
`