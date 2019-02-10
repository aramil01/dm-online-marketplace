package org.product.service;

import java.util.ArrayList;

import org.product.models.ProductDto;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Interface
 * @author Aramil
 *
 */
public interface IProductService {
	/**
     * Récuperation d'un produit à partir de son identifiant
     * @param id identifiant du roduit
     * @return produit
     */
    public ProductDto getProduct (String id);
    /**
     * Récupération de la liste des produits
     * @return la liste des produits
     */
    public  ArrayList<ProductDto> getAllProducts();
    /**
     * Ajout d'un produit
     * @param product le produit à ajouter
     */
    public  void addProduct(ProductDto product);
/**
 * Mise à jour d'un produit    
 * @param product produit à mettre à jour
 * @return le produit mis à jour
 */
    public  ProductDto updateProduct(ProductDto product);
    /**
     * Suppression d'un produit
     * @param id  l'identifiants du produit
     */
    public void deleteProduct(@PathVariable String id);


    
    

}
