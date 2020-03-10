class BicicletaCarretera < Bicicleta
  
  #Variable de clase
  @@count = 0
  
  def initialize
    @@count += 1 
    @tipo = Tipo::CARRETERA
    @id = @@count
  end
  
  
end
