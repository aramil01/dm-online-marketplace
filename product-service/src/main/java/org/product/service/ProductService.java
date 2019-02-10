package org.product.service;

import java.util.ArrayList;

import org.product.models.ProductDto;
import org.springframework.stereotype.Service;
@Service
public class ProductService implements IProductService{
	/**
     * creation d'une liste de produits
     * @return products la liste des produits
     */
    
    public ArrayList<ProductDto> buildProduct () {
    	  ProductDto product = new ProductDto();
          product.setId("1");
          product.setDescription("description 1");
          product.setName("name 1");
          product.setPrice(1);
          product.setUrlImage("urlImage 1");
          ProductDto product2 = new ProductDto();
          product2.setId("2");
          product2.setDescription("description 2");
          product2.setName("name 2");
          product2.setPrice(2);
          product2.setUrlImage("urlImage 2");
          
          ArrayList<ProductDto> products = new ArrayList<ProductDto>();
          products.add(product);
          products.add(product2);
		return products;
    }
    /**
     * Récuperation d'un produit à partir de son identifiant
     * @param id identifiant du roduit
     * @return produit
     */
    public ProductDto getProduct (String id) {
    	ProductDto oneProduct= new ProductDto();
    	for (ProductDto product : buildProduct()) {
    		if(product.getId().equals(id)) {
    			oneProduct=product;
    		}
    		}
    	return oneProduct;
    	}
    /**
     * Récupération de la liste des produits
     * @return la liste des produits
     */
	public ArrayList<ProductDto> getAllProducts() {
		return buildProduct();
	}
	  /**
     * Ajout d'un produit
     * @param product le produit à ajouter
     */
	public void addProduct(ProductDto product) {
		
	}
	/**
	 * Mise à jour d'un produit    
	 * @param product produit à mettre à jour
	 * @return le produit mis à jour
	 */
	public ProductDto updateProduct(ProductDto product) {
		return null;
	}
	  /**
     * Suppression d'un produit
     * @param id  l'identifiants du produit
     */
	public void deleteProduct(String id) {
		
	}
}
