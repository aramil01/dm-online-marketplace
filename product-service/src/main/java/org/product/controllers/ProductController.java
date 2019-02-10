package org.product.controllers;

import java.util.ArrayList;

import org.product.models.ProductDto;
import org.product.service.IProductService;
import org.product.utils.RouteLogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api Rest Controller
 */

@RestController
public class ProductController {
	@Autowired
	RouteLogAspect log;
	@Autowired
	IProductService productService;

	/**
	 * retourne un produit
	 * 
	 * @param id identifiant du produit
	 * @return product un produit
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/products/get/{id}", headers = "Accept=*/*")
	@ResponseBody
	ProductDto getOneProduct(@PathVariable String id, HttpRequest request) {
		ProductDto product = productService.getProduct(id);
		return product;
	}

	/**
	 * retourne la liste des produits
	 * 
	 * @param id identifiant du produit
	 * @return products la liste des produits
	 */
	@RequestMapping(method = RequestMethod.GET,value="/products/getAll", headers = "Accept=*/*")
	@ResponseBody
	public ArrayList<ProductDto> getAllProducts(HttpRequest request) {
		ArrayList<ProductDto> products = productService.getAllProducts();
		return products;
	}

	/**
	 * Ajout d'un produit
	 * 
	 * @param ProductDto le produit
	 */
	@RequestMapping(method = RequestMethod.POST,value="/products/add", headers = "Accept=*/*")
	@ResponseBody
	public void addProduct(@RequestBody ProductDto product, HttpRequest request) {
		productService.addProduct(product);

	}

	/**
	 * Modification du produit
	 * 
	 * @param id identifiant du produit
	 * @return product le produit
	 */
	@RequestMapping(method = RequestMethod.PUT, value="/products/upadte",headers = "Accept=*/*")
	@ResponseBody
	public ProductDto updateProduct(@RequestBody ProductDto product, HttpRequest request) {
		productService.updateProduct(product);
		return product;
	}

	/**
	 * suppression de produit
	 * 
	 * @param id identifiant du produit
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/delete/{id}", headers = "Accept=*/*")
	@ResponseBody
	public void deleteProduct(@PathVariable String id, HttpRequest request) {
		productService.deleteProduct(id);
	}

}
