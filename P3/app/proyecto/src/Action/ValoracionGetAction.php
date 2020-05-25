<?php

namespace App\Action;

use App\Domain\Valoracion\Data\ValoracionData;
use App\Domain\Valoracion\Service\ValoracionGetter;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;

final class ValoracionGetAction {
    /**
     * Servicio
     *
     * @var ValoracionGetter servicio para consultar Valoracions
     */
    private $ValoracionGetter;

    /**
     * El constructor
     *
     * @param ValoracionGetter $ValoracionGetter
     */
    public function __construct(ValoracionGetter $ValoracionGetter) {
        $this->ValoracionGetter = $ValoracionGetter;
    }

    /**
     * Método invocado en la creación
     *
     * @param ServerRequestInterface $request
     * @param ResponseInterface $response
     * @return ResponseInterface
     */
    public function __invoke(ServerRequestInterface $request, ResponseInterface $response): ResponseInterface {
        // Recolectar datos del request
        $data = (array)$request->getParsedBody();
        // Obtener parámetros de la ruta
        $params = \Slim\Routing\RouteContext::fromRequest($request)->getRoute()->getArguments();

        $Valoracion = new ValoracionData();
        $Valoracion->valorablesEntidadesId = $params['valorablesEntidadesId'];
        $Valoracion->valorablesId = $data['valorablesId'];
        $Valoracion->usuariosNombre = $data['usuariosNombre'];
        
        $resultado = $this->ValoracionGetter->getValoracion($Valoracion);
        
        // Construir la respuesta HTTP
        $response->getBody()->write((string)json_encode($resultado, JSON_UNESCAPED_UNICODE));

        return $response->withHeader('Content-Type', 'application/json');
    }
}