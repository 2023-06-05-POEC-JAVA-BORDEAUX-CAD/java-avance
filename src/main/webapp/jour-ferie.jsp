<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>TP Jour ferie</title>
	<style>
		body {
			font-size: 14px;
			font-family: Arial, sans-serif;
			background: #0f0f0f;
			color: #bdc1c6;
		}

		form {
			background: #161616;
			box-sizing: border-box;
			display: block;
			max-width: min(90vw, 600px);
			margin: min(4vw, 16px) auto;
			padding: 24px;
			display: flex;
			flex-direction: column;
			align-content: center;
			flex-wrap: nowrap;
			justify-content: center;
			align-items: center
		}

		input,
		button {
			border-radius: 6px;
			padding: 8px 12px;
			border: none;
			margin: 6px;
			outline: none;
			background: #222222;
			color: #bdc1c6;
		}

		/* Chrome, Safari, Edge, Opera */
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
			-webkit-appearance: none;
			margin: 0;
		}

		/* Firefox */
		input[type=number] {
			-moz-appearance: textfield;
		}
	</style>
</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/jour-ferie-result" method="post">
		<input type="number" name="j" id="j" placeholder="Jour">
		<input type="number" name="m" id="m" placeholder="Mois">
		<input type="number" name="a" id="a" placeholder="Annee">
		<button type="submit">Alors ?</button>
	</form>
</body>

</html>