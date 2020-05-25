<?php

namespace App\Action;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Service\ValoracionModifier;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

final class ValoracionModifyAction {
    /**
     * Servicio
     *
     * @var ValoracionModifier servicio para consultar Valoracions
     */
    private $ValoracionModifier;

    /**
     * El constructor
     *
     * @param ValoracionModifier $ValoracionModifier
     */
    public function __construct(ValoracionModifier $ValoracionModifier) {
        $this->ValoracionModifier = $ValoracionModifier;
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
        $Valoracion->puntuacion = $data['puntuacion'];
        $Valoracion->comentario = $data['comentario'];
        $Valoracion->fecha = $data['fecha'];

        // Obtener el resultado de la operación y generar código de respuesta
        $resultado = (bool) $this->ValoracionModifier->modificarValoracion($Valoracion);
        ($resultado) ? $status = 200 : $status = 409;
        
        // Construir la respuesta HTTP
        $response->getBody()->write(json_encode(['success' => $resultado]));

        return $response->withHeader('Content-Type', 'application/json')->withStatus($status);
    }
}