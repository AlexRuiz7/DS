<?php namespace App\Cotrollers;

use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;

class UsuariosController{
    public function getAll($request,$response,$arg){
        $response->getBody()->write("Hello world!");
        return $response;
    }
}
