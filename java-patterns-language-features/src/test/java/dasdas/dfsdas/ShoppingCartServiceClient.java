//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@FeignClient(name = "cart-service", url = "http://shopping-cart")
//public interface ShoppingCartServiceClient
//{
//    @GetMapping("/api/v1/shopping-cart")
//    CartDto getClientCart(); // N sec
//}
//
//@FeignClient(name = "recommendations-service", url = "http://recommendations")
//public interface RecommendationsServiceClient
//{
//    @GetMapping("/api/v1/recommendations")
//    List<RecommendationDto> getClientRecommendations(); // N sec
//}
//
//public record ClientCartScreenDto(CartDto cart, List<RecommendationDto> recommendations)
//
//@Service
//public class ClientCartScreenService
//{
//
//    public ClientCartScreenDto getScreenData()
//    {
//
//
//        CompletableFuture cardResult = new Thread(() -> {
//            CartDto cart = feignClient.getClientCart();
//        }).start()
//
//        CompletableFuture recommendationsResult = new Thread(() -> {
//            List<RecommendationDto> recommendations = feignClient.getClientRecommendations();
//        }).start()
//
//
//        cardResult.join();
//        recommendationsResult.join();
//    }
//}
//
//
//
//
//
//
//
//
//
//        return new
//
//ClientCartScreenDto(cart, recommendations);
//    }
//            }
//
//// допродажа
//// рекомендации на странице корзины
//// bff