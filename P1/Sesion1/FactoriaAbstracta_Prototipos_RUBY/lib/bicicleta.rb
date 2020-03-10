class Bicicleta
  
  attr_accessor :id, :tipo, :ttl, :DEFAULT_TTL
  
  
  def initialize
    @DEFAULT_TTL = 15
  end
  
  def setAbandono(tiempo)
    @ttl = tiempo
  end
  
  def fin
    @ttl = tiempo
  end
  
  def to_s
    puts "\nBicicleta de tipo #{@tipo} \n Número: #{@id}"
  end
  
end
