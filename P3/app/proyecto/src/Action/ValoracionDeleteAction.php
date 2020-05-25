<?php

namespace App\Action;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Service\ValoracionDeleter;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

final class ValoracionDeleteAction {
    /**
     * Servicio
     *
     * @var ValoracionDeleter servicio para eliminar Valoracions
     */
    private $ValoracionDeleter;

    /**
     * El constructor
     *
     * @param ValoracionDeleter $ValoracionDeleter
     */
    public function __construct(ValoracionDeleter $ValoracionDeleter) {
        $this->ValoracionDeleter = $ValoracionDeleter;
    }

    /**
     * Método invocado en la creación
     *
     * @param ServerRequestInterface $request
     * @param ResponseInterface $response
     * @return ResponseInterface
     */
    public function __invoke(ServerRequestInterface $request, ResponseInterface $response): ResponseInterface {
        // Obtener parámetros de la ruta
        $data = (array)$request->getParsedBody();

        // Mapping
        $Valoracion = new ValoracionData();
        $Valoracion->valorablesEntidadesId = $data['valorablesEntidadesId'];
        $Valoracion->valorablesId = $data['valorablesId'];
        $Valoracion->usuariosNombre = $data['usuariosNombre'];

        // Obtener el resultado de la operación y generar código de respuesta
        $resultado = (bool) $this->ValoracionDeleter->eliminarValoracion($Valoracion);
        ($resultado) ? $status = 200 : $status = 409;
        
        // Construir la respuesta HTTP
        $response->getBody()->write(json_encode(['success' => $resultado]));

        return $response->withHeader('Content-Type', 'application/json')->withStatus($status);
    }
}