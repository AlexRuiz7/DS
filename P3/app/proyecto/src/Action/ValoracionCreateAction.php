<?php

namespace App\Action;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Service\ValoracionCreator;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

final class ValoracionCreateAction {
    private $ValoracionCreator;

    public function __construct(ValoracionCreator $ValoracionCreator) {
        $this->ValoracionCreator = $ValoracionCreator;
    }

    public function __invoke(ServerRequestInterface $request, ResponseInterface $response): ResponseInterface {
        // Recolectar datos de entrada desde la petición HTTP
        $data = (array)$request->getParsedBody();

        // Mapping
        $Valoracion = new ValoracionData();
        $Valoracion->valorablesEntidadesId = $data['valorablesEntidadesId'];
        $Valoracion->usuariosNombre = $data['usuariosNombre'];
        $Valoracion->puntuacion = $data['puntuacion'];
        $Valoracion->comentario = $data['comentario'];
        $Valoracion->fecha = $data['fecha'];

        // Invocar a la capa de lógica Domain con los datos de entrada, y obtener el resultado
        $resultado = (bool) $this->ValoracionCreator->crearValoracion($Valoracion);
        ($resultado) ? $status = 201 : $status = 409;

        // Construir la respuesta HTTP
        $response->getBody()->write((string)json_encode(['success' => $resultado]));

        return $response->withHeader('Content-Type', 'application/json')->withStatus($status);
    }
}

?>